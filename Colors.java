package Sapper;

import java.awt.*;

public class Colors {

    public static Color Color(int i){
        switch (i){
            case 1: return Color1();
            case 2: return Color2();
            case 3: return Color3();
            case 4: return Color4();
            case 5: return Color5();
            case 6: return Color6();
            case 7: return Color7();
            case 8: return Color8();
            default: return Color0();
        }
    }

    public static Color Color0(){
        return new Color(255,255,0);
    }

    public static Color Color1(){
        return new Color(255,225,0);
    }

    public static Color Color2(){
        return new Color(255,195,0);
    }

    public static Color Color3(){
        return new Color(255,165,0);
    }

    public static Color Color4(){
        return new Color(255,135,0);
    }

    public static Color Color5(){
        return new Color(255,105,0);
    }

    public static Color Color6(){
        return new Color(255,75,0);
    }

    public static Color Color7(){
        return new Color(255,45,0);
    }

    public static Color Color8(){
        return new Color(255,15,0);
    }
}
