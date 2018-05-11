package ua.kiyv.training.library.controller.command.search;

@FunctionalInterface
public interface SomeFuncInter {

    Integer someAction(String s);

    static SomeFuncInter getInstance(){
        return Integer::parseInt;
    }

    static SomeFuncInter gerAnotherInstance(){
        return s -> {
           s += "1523446";
            return Integer.parseInt(s) + 1000;
        };
    }




}
