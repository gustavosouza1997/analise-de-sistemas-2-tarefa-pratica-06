package utils;

public class Utils {
    public String getHorarioAtual () {
        return java.time.LocalTime.now().toString().substring(0, 5);
    }
}
