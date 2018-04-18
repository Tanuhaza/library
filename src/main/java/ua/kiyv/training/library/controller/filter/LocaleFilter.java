package ua.kiyv.training.library.controller.filter;


import ua.kiyv.training.library.controller.i18n.LocaleHolder;
import ua.kiyv.training.library.utils.constants.Attributes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Filter which sets character encoding to utf-8
 * This filter also sets and changes locales
 */
@WebFilter(urlPatterns = {"/library/*"})
public class LocaleFilter implements Filter {
    /**
     * contains all supported locales
     */
    private LocaleHolder localeHolder = new LocaleHolder(LocaleHolder.DEFAULT_LOCALE);
    private static final String MESSAGE_PATH = "webProject.i18n.messages";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = ((HttpServletRequest) request);
        req.setCharacterEncoding(Attributes.UTF_8);
        HttpSession session = req.getSession();
        setResourceBundle(session);
        Locale locale = localeHolder.getCurrentLocale();
        String localeName = extractLocale(req);
        if (localeName != null) {
            locale = findSupportedLocale(localeName);
        }
        req.setAttribute(Attributes.LOCALE, locale);
        session.setAttribute(Attributes.LOCALE, locale);
        session.setAttribute("SUPPORTED_LOCALES", LocaleHolder.SUPPORTED_LOCALES);
        System.out.println("IN LOCALE FILTRE");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    private String extractLocale(HttpServletRequest request) {
        return request.getParameter(Attributes.LANG);
    }

    private Locale findSupportedLocale(String localeName) {
        for (Locale locale : LocaleHolder.SUPPORTED_LOCALES) {
            if (locale.getLanguage().equals(localeName)) {
                localeHolder.setCurrentLocale(locale);
                return locale;
            }
        }
        return LocaleHolder.DEFAULT_LOCALE;
    }

    private void setResourceBundle(HttpSession session) {
        if (session.getAttribute(Attributes.BUNDLE_FILE) == null) {
            session.setAttribute(Attributes.BUNDLE_FILE, MESSAGE_PATH);
        }
    }
}