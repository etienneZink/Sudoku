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
        test = main.gueltig(1,2,sudoku);
        if(test == true){
            system.out.println("gültig");
        }
        else{
            system.out.println("ungültig"); 
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
        while(finsish == false){

        }        
        return sudoku;
    }

    public boolean gueltig(int x, int y, int[][] sudoku){
        boolean gueltig = false;
        boolean reihe = true;
        boolean spalte = true;
        boolean box = true;
    
        for (int i = 0; i < 8; i++){
            if(sudoku[x][y] == sudoku[i][y]){
                reihe = false;
            }
        }
        for (int i = 0; i < 8; i++){
            if(sudoku[x][y] == sudoku[x][i]){
                spalte = false;
            }
        }
        
        int xstart = x - (x % 3);
        int ystart = y - (y % 3);
        for (int i = xstart; i < xstart + 1; i++){
            for (int j = ystart; i < ystart + 1; j++){
                if(sudoku[x][y] == sudoku[i][j]){
                    box = false;
                }
            }
        }
        if(reihe == true && spalte == true && box == true){
            gueltig = true;
        }

        return gueltig;
    }
}