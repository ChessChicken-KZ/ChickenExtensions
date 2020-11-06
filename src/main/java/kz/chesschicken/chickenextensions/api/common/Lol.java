package kz.chesschicken.chickenextensions.api.common;

import com.google.gson.internal.$Gson$Preconditions;

public class Lol {
    private Object yeskendir;
    private Object astolfo = "https://google.com/q=astolfo";

    public Lol()
    {
        yeskendir = "Trap";
    }

    @Deprecated
    private boolean isYeskendirAstolfo(){
        return astolfo.equals(yeskendir);
    }

    public boolean isYeskendirAstolfo1() {
        return true;
    }
}
