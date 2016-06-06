import java.util.*;

/**
 * Created by tonik on 06.06.16.
 */
public class X0
{
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static final char AI_DOT = '0', USER_DOT = 'X', EMPTY_DOT = '*';
    static int[][] field = new int[5][5];

    public static void main(String[] args)
    {
        fillField();
        printField();

        while(true)
        {
            userTurn();
            printField();
            aiTurn();
            printField();
        }

    }

    static void fillField ()
    {
        for(int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field.length; j++)
            {
                field[i][j] = EMPTY_DOT;
            }
        }

    }

    static void printField()
    {
        int n;
        System.out.println();
        System.out.println("    1   2   3   4   5  ");
        for(int i = 0; i < field.length; i++)
        {
            n = i + 1;
            System.out.println("  +---+---+---+---+---+");
            System.out.print(n + " ");
            for (int j = 0; j < field.length; j++)
            {

                System.out.print("| " + (char)field[i][j] + " ");
            }

            System.out.println("|");
        }
        System.out.println("  +---+---+---+---+---+");
        System.out.println();
    }

    static void setX0(int x, int y, char xo)
    {
        field[x][y] = xo;
    }

    static void userTurn()
    {
        int x, y;
        do
        {
            System.out.println("Enter coordinates in format X Y (1 - 5):");
            x = scanner.nextInt();
            y = scanner.nextInt();

        }
        while(!isCellempty(x - 1, y -1));

        setX0(x - 1, y - 1, USER_DOT);
    }

    static void aiTurn()
    {
        int x, y;
        do
        {
            System.out.println("Computer turn...");
            x = random.nextInt(5);
            y = random.nextInt(5);
        }
        while(!isCellempty(x, y));

        setX0(x, y, AI_DOT);
    }

    static boolean isCellempty(int x, int y)
    {
        if (x < 0 || y < 0 || x > 4 || y > 4)
        {
            System.out.println("Bad coordinates!!!");
            return false;
        }
        if (field[x][y] == '*') return true;

        return false;
    }

    public static boolean isFieldFull()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (field[i][j] == '*') return false;
            }
        }
        return true;
    }
}
