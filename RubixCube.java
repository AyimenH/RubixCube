import java.util.*;

/*
    6 Faces - RED BLUE GREEN ORANGE WHITE YELLOW:

                R R R 
                R R R
                R R R

        G G G   W W W   B B B   Y Y Y
        G G G   W W W   B B B   Y Y Y
        G G G   W W W   B B B   Y Y Y

                O O O
                O O O
                O O O

    To Rotate View: "W" to rotate up
                    "S" to rotate down
                    "A" to rotate left
                    "D" to rotate right
    To Move Face:   "R" to move right col up, "R'" to move right col down
                    "Q" to move top row left, "U'" to move top row right
                    "L" to move left col up, "L'" to move left col down
                    "E" to move bottom row left, "B'" to move bottom row right

*/

public class RubixCube {

    String[][] front = {{"W","W","W"},
                        {"W","W","W"},
                        {"W","W","W"}};

    String[][] back =  {{"Y","Y","Y"},
                        {"Y","Y","Y"},
                        {"Y","Y","Y"}};

    String[][] bottom =   {{"R","R","R"},
                        {"R","R","R"},
                        {"R","R","R"}};

    String[][] top = {{"O","O","O"},
                        {"O","O","O"},
                        {"O","O","O"}};
    
    String[][] left =  {{"G","G","G"},
                        {"G","G","G"},
                        {"G","G","G"}};

    String[][] right =  {{"B","B","B"},
                        {"B","B","B"},
                        {"B","B","B"}};
    
    String[][] temp;
    List<String[][]> layout;
    Random rand = new Random();

    public RubixCube(){
        
    }

    public void rotate(char direction){
        switch(direction){
            case 'w':
                temp = front;
                front = bottom;
                bottom = back;
                back = top;
                top = temp;
                break;
            case 's':
                temp = bottom;
                bottom = front;
                front = top;
                top = back;
                back = temp;
                break;
            case 'a':
                temp = left;
                left = front;
                front = right;
                right = back;
                back = temp;
                break;
            case 'd':
                temp = right;
                right = front;
                front = left;
                left = back;
                back = temp;
                break;
        }
    }

    public void move(char move){
        switch(move){
            case 's':
                scramble();
                break;
            case 'r':
                String[] tempColR = {front[0][2],front[1][2],front[2][2]};
                front[0][2] = bottom[0][2];
                front[1][2] = bottom[1][2];
                front[2][2] = bottom[2][2];

                bottom[0][2] = back[0][2];
                bottom[1][2] = back[1][2];
                bottom[2][2] = back[2][2];

                back[0][2] = top[0][2];
                back[1][2] = top[1][2];
                back[2][2] = top[2][2];

                top[0][2] = tempColR[0];
                top[1][2] = tempColR[1];
                top[2][2] = tempColR[2];
                break;
            case 'l':
                String[] tempColL = {front[0][0],front[1][0],front[2][0]};
                front[0][0] = bottom[0][0];
                front[1][0] = bottom[1][0];
                front[2][0] = bottom[2][0];

                bottom[0][0] = back[0][0];
                bottom[1][0] = back[1][0];
                bottom[2][0] = back[2][0];

                back[0][0] = top[0][0];
                back[1][0] = top[1][0];
                back[2][0] = top[2][0];

                top[0][0] = tempColL[0];
                top[1][0] = tempColL[1];
                top[2][0] = tempColL[2];
                break;
            case 'q':
                String[] tempColq = {front[0][0],front[0][1],front[0][2]};
                front[0][0] = right[0][0];
                front[0][1] = right[0][1];
                front[0][2] = right[0][2];

                right[0][0] = back[0][0];
                right[0][1] = back[0][1];
                right[0][2] = back[0][2];

                back[0][0] = left[0][0];
                back[0][1] = left[0][1];
                back[0][2] = left[0][2];

                left[0][0] = tempColq[0];
                left[0][1] = tempColq[1];
                left[0][2] = tempColq[2];
                break;
            case 'e':
                String[] tempCole = {front[2][0],front[2][1],front[2][2]};
                front[2][0] = right[2][0];
                front[2][1] = right[2][1];
                front[2][2] = right[2][2];

                right[2][0] = back[2][0];
                right[2][1] = back[2][1];
                right[2][2] = back[2][2];

                back[2][0] = left[2][0];
                back[2][1] = left[2][1];
                back[2][2] = left[2][2];

                left[2][0] = tempCole[0];
                left[2][1] = tempCole[1];
                left[2][2] = tempCole[2];
                break;
            
        }

    }

    public void scramble(){
        char[] randmoves = {'r','l','q','e'};
        int i = 0;
        while(i<150){
            move(randmoves[rand.nextInt(3)]);
            move(randmoves[rand.nextInt(3)]);
            i++;
        }
        
    }
    
    public void print(){
        for (int row=0;row<3;row++){
            System.out.print("        ");
            printRow(top,row);
            System.out.println();
        }

        for (int row=0;row<3;row++){
            printRow(left, row);
            System.out.print("  ");
            printRow(front, row);
            System.out.print("  ");
            printRow(right, row);
            System.out.print("  ");
            printRow(back,row);
            System.out.println("  ");
        }

        for (int row=0;row<3;row++){
            System.out.print("        ");
            printRow(bottom,row);
            System.out.println();
        }
        System.out.println("\n\n");

        

    }

    private void printRow(String[][] face,int row){
        for(int i=0;i<3;i++){
            System.out.print(face[row][i] + " ");
        }
    }

}
