public class Main {
    public static void main(String[] argv){
        int[][] sudoku = {
            {0,3,0,0,0,0,0,0,0},
            {0,0,0,1,9,5,0,0,0},
            {0,0,8,0,0,0,0,6,0},  
            {8,0,0,0,6,0,0,0,0},
            {4,0,0,8,0,0,0,0,1},
            {0,0,0,0,2,0,0,0,0},
            {0,6,0,0,0,0,2,8,0},
            {0,0,0,4,1,9,0,0,5},
            {0,0,0,0,0,0,0,7,0}              
        };
        Main main = new Main();
        boolean test = false;
        test = main.gueltig(1,3,sudoku);
        if(test == true){
            System.out.println("gültig");
        }
        else{
            System.out.println("ungültig" ); 
        }

    }
    int[][] sudoku = {
        {0,3,0,0,0,0,0,0,0},
        {0,0,0,1,9,5,0,0,0},
        {0,0,8,0,0,0,0,6,0},  
        {8,0,0,0,6,0,0,0,0},
        {4,0,0,8,0,0,0,0,1},
        {0,0,0,0,2,0,0,0,0},
        {0,6,0,0,0,0,2,8,0},
        {0,0,0,4,1,9,0,0,5},
        {0,0,0,0,0,0,0,7,0}              
    };

    int[][] preseted = {
        {0,1},{1,3},{1,4},{1,5},{2,2},{2,7},{3,0},{3,4},{4,0},{4,3},{4,8},{5,4},{6,1},{6,6},{6,7},{7,3},{7,4},{7,5},{7,8},{8,7}

    };

    public int[][] sudokuLoesung(int[][] sudoku){
        boolean finish = false;
        while(finish == false){

        }        
        return sudoku;
    }

    public boolean gueltig(int x, int y, int[][] sudoku){
        boolean gueltig = false;
        boolean reihe = true;
        boolean spalte = true;
        boolean box = true;
    
        for (int i = 0; i < 8; i++){
            if(sudoku[x][y] == sudoku[i][y] && x != i){
                reihe = false;
            }
        }
        for (int i = 0; i < 8; i++){
            if(sudoku[x][y] == sudoku[x][i] && y != i){
                spalte = false;
            }
        }
        
        int xstart = x - (x % 3);
        int ystart = y - (y % 3);
        for (int i = xstart; i <= (xstart + 2); i++){
            for (int j = ystart; j <= (ystart + 2); j++){
                if(sudoku[x][y] == sudoku[i][j] && x != i && y != j){
                    box = false;
                }
            }
        }
        if(reihe){
            if(spalte){
                if(box){
                    gueltig = true;
                }
            }
        }

        return gueltig;
    }
}