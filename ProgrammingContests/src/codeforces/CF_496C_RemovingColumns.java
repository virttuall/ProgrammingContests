package codeforces;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CF_496C_RemovingColumns {
public static void main(String[] args) throws IOException
{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder("");
    int row, column;
    String lines[] = in.readLine().split(" ");
    row = Integer.parseInt(lines[0]);
    column = Integer.parseInt(lines[1]);
    char[][] matrix = new char[row][column];
    for ( int i = 0; i < row; i++)
    {
        matrix[i] = in.readLine().toCharArray();
    }
    boolean arr[] = new boolean[row];
    boolean flag;
    ArrayList<Integer> list;
    int count = 0;
    if ( row != 1)
    {
    for ( int j = 0;j < column; j++ )
    {
        flag = false;
        list = new ArrayList<Integer>();
        for ( int i = 1; i < row; i++ )
        {
            if ( !arr[i])
            {
                if ( matrix[i-1][j] < matrix[i][j])
                {
                    list.add(i);
                }
                else if ( matrix[i-1][j] > matrix[i][j])
                {
                    flag = true;
                    break;
                }
            }   
        }
        if ( flag) { count++; }
        else {
            for ( int i = 0;i < list.size(); i++ )
                arr[list.get(i)] = true;
        }
    }
    System.out.println(count);
    }
    else
    {
        System.out.println(0);
    }
}
}