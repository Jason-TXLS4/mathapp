package ca.echocreativeworks.mathapp;


abstract class EquationTools {



        public static int setLevel(String type, int level) {
            if (type.equals("div")) {
                switch (level) {
                    case 1:
                        return 2;
                    case 2:
                        return 4;
                    case 3:
                        return 6;
                    case 4:
                        return 8;
                    case 5:
                        return 10;
                    case 6:
                        return 12;
                    case 7:
                        return 13;
                    case 8:
                        return 14;
                    case 9:
                        return 15;
                }
            } else {
                switch (level) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 5:
                        return 5;
                    case 6:
                        return 6;
                    case 7:
                        return 7;
                    case 8:
                        return 8;
                    case 9:
                        return 9;
                }//end swtich
            }//end if
            return -1;
        }//end setLevel()


}
