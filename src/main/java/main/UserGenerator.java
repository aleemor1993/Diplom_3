package main;

import java.util.Random;

public class UserGenerator {

    public static String generateUserEmail()
    {
        return "johnnletsit" + new Random().nextInt(200) + "snow@yandex.ru";

    }

    public static String generic(){
        return "alexandra.morkvina@yandex.ru";
    }

}
