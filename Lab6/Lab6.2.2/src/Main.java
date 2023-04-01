import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    /*
    8.	На клетчатом листе бумаги закрашена часть клеток.
        Выделить все различные фигуры, которые образовались при этом.
        Фигурой считается набор закрашенных клеток, достижимых друг из друга при движении в четырёх направлениях.
        Две фигуры являются различными, если их нельзя совместить поворотом на угол, кратный 90 градусам,
        и параллельным переносом. Используйте класс HashSet.
     */
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        int[][] matrix;
        ArrayList<String> pos = new ArrayList<>();

        /*matrix= new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}};*/
        matrix= new int[][]{
                {1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}};

        for(int i=0;i<4; i++){
            for (int j=0; j<5; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        int[][] mat1;
        int countX=0;
        int countY=0;
        for(int i=0;i<3; i++){
            countX=0;
            countY=0;
            for (int j=0; j<4; j++){

                if(matrix[i][j]==1){

                    if(matrix[i][j+1]==1){
                        countX++;
                    }
                    if(matrix[i+1][j]==1){
                        countY++;
                    }
                }
            }
            countX++;
            countY++;
            pos.add("X"+countX+"Y"+countY);
        }
        for (int i=0;i< pos.size(); i++){
            set.add(pos.get(i));
        }
        System.out.println(set);
    }
}