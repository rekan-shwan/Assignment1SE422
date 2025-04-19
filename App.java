// Rekan Shwan  rs21131@auis.edu.krd
// Shakar Latif sl21081@auis.edu.krd


public class App {    
    public static void main(String[] args) {
        Utilities.printColoredln(
            "Welcome to the File Extension Filter App!\n" +
            "This app allows you to filter files in a directory by their extensions.\n" +
            "You can also count the number of files with a specific extension.\n" +
            "Let's get started!\n", Utilities.GREEN);
        counterPDF();
    }

    public static void counterPDF(){
        String path = "/";
        Details details = new Details();
    do {
        Utilities.printColoredln("Please enter the path:", Utilities.YELLOW);
        path = Utilities.getUserInput();
        
        if (details.setPath(path)) {
            Utilities.printColoredFormatted("Path set successfully! \n", Utilities.GREEN, "%s", path);
            break;
        } else {
            Utilities.printColoredln("Invalid path. Please try again.\n", Utilities.RED);
        }
    } while (true);

    Utilities.closeScanner();
    FileCounting fileCounter = new FileCounting(details.getPath());
    
    fileCounter.singleThreadCount();
    fileCounter.multiThreadCount(4);
    fileCounter.threadPoolPDFCount(Runtime.getRuntime().availableProcessors()/2);

    } 
}

