import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsideDirectory {

    public static String gap = "";

    public static void main(String[] args) throws IOException {

        System.out.println("Введите адрес директории: ");
        String adress = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        try {
            listDirectory(adress);
        }catch (NullPointerException e){
            System.out.println("Адрес не найден, либо введен неверно");
        }

    }


    private static void isDirect(File elementFile) {

        if (elementFile.isDirectory()) {
            InsideDirectory.gap = InsideDirectory.gap + "                    ";
            listDirectory(String.valueOf(elementFile));
            InsideDirectory.gap = InsideDirectory.gap.replaceFirst("                    ","");
        }
    }


    private static void listDirectory(String str) {

        File file = new File(str);
        File arrayF[] = file.listFiles();

        for (File itemFile : arrayF) {
            if (itemFile.isFile()){
                System.out.println(InsideDirectory.gap + itemFile.getName() + "   " + itemFile.length() + " байт");
            }else {
                System.out.println(InsideDirectory.gap + itemFile.getName());
            }
            isDirect(itemFile);
        }
        System.out.println();
    }


}






