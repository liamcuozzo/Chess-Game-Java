public interface Global {
    boolean white = true;
    boolean black = false;

    // Reset
     String RESET = "\033[0m";  // Text Reset

    // Regular Colors
     String BLACK = "\033[030m";   // BLACK
     String RED = "\033[031m";     // RED
     String GREEN = "\033[032m";   // GREEN
     String YELLOW = "\033[033m";  // YELLOW
     String BLUE = "\033[034m";    // BLUE
     String PURPLE = "\033[035m";  // PURPLE
     String CYAN = "\033[036m";    // CYAN
     String WHITE = "\033[037m";   // WHITE

    // Bold
     String BLACK_BOLD = "\033[130m";  // BLACK
     String RED_BOLD = "\033[131m";    // RED
     String GREEN_BOLD = "\033[132m";  // GREEN
     String YELLOW_BOLD = "\033[133m"; // YELLOW
     String BLUE_BOLD = "\033[134m";   // BLUE
     String PURPLE_BOLD = "\033[135m"; // PURPLE
     String CYAN_BOLD = "\033[136m";   // CYAN
     String WHITE_BOLD = "\033[137m";  // WHITE

    // Underline
     String BLACK_UNDERLINED = "\033[430m";  // BLACK
     String RED_UNDERLINED = "\033[431m";    // RED
     String GREEN_UNDERLINED = "\033[432m";  // GREEN
     String YELLOW_UNDERLINED = "\033[433m"; // YELLOW
     String BLUE_UNDERLINED = "\033[434m";   // BLUE
     String PURPLE_UNDERLINED = "\033[435m"; // PURPLE
     String CYAN_UNDERLINED = "\033[436m";   // CYAN
     String WHITE_UNDERLINED = "\033[437m";  // WHITE

    // Background
     String BLACK_BACKGROUND = "\033[40m";  // BLACK
     String RED_BACKGROUND = "\033[41m";    // RED
     String GREEN_BACKGROUND = "\033[42m";  // GREEN
     String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
     String BLUE_BACKGROUND = "\033[44m";   // BLUE
     String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
     String CYAN_BACKGROUND = "\033[46m";   // CYAN
     String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
     String BLACK_BRIGHT = "\033[090m";  // BLACK
     String RED_BRIGHT = "\033[091m";    // RED
     String GREEN_BRIGHT = "\033[092m";  // GREEN
     String YELLOW_BRIGHT = "\033[093m"; // YELLOW
     String BLUE_BRIGHT = "\033[094m";   // BLUE
     String PURPLE_BRIGHT = "\033[095m"; // PURPLE
     String CYAN_BRIGHT = "\033[096m";   // CYAN
     String WHITE_BRIGHT = "\033[097m";  // WHITE

    // Bold High Intensity
     String BLACK_BOLD_BRIGHT = "\033[190m"; // BLACK
     String RED_BOLD_BRIGHT = "\033[191m";   // RED
     String GREEN_BOLD_BRIGHT = "\033[192m"; // GREEN
     String YELLOW_BOLD_BRIGHT = "\033[193m"; // YELLOW
     String BLUE_BOLD_BRIGHT = "\033[194m";  // BLUE
     String PURPLE_BOLD_BRIGHT = "\033[195m"; // PURPLE
     String CYAN_BOLD_BRIGHT = "\033[196m";  // CYAN
     String WHITE_BOLD_BRIGHT = "\033[197m"; // WHITE

    // High Intensity backgrounds
     String BLACK_BACKGROUND_BRIGHT = "\033[0100m"; // BLACK
     String RED_BACKGROUND_BRIGHT = "\033[0101m"; // RED
     String GREEN_BACKGROUND_BRIGHT = "\033[0102m"; // GREEN
     String YELLOW_BACKGROUND_BRIGHT = "\033[0103m"; // YELLOW
     String BLUE_BACKGROUND_BRIGHT = "\033[0104m"; // BLUE
     String PURPLE_BACKGROUND_BRIGHT = "\033[0105m"; // PURPLE
     String CYAN_BACKGROUND_BRIGHT = "\033[0106m";  // CYAN
     String WHITE_BACKGROUND_BRIGHT = "\033[0107m";   // WHITE
}
