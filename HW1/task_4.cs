int[,] IntMatrix(int rows, int columns, int min, int max) 
{
    int[,] matrix = new int[rows, columns];
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            matrix[i, j] = new Random().Next(min, max + 1);
        }
    }
    return matrix;
}

void PrintMatrix(int[,] matrix)  
{
    for (int i = 0; i < matrix.GetLength(0); i++)
    {
        for (int j = 0; j < matrix.GetLength(1); j++)
        {
            if (matrix[i, j] >= 0 && matrix[i, j] < 10)
                System.Console.Write("0" + matrix[i, j] + " ");
            else
                System.Console.Write(matrix[i, j] + " ");
        }
        System.Console.WriteLine();
    }
}

void MatrixCube(int[,] matrix) 
{
    try
    {
        if (matrix.GetLength(0) != matrix.GetLength(1))
        {
            throw new Exception("Длина строк и столбцов не одинакова!");
        }
    }
    catch (Exception e)
    {
        Console.WriteLine($"Ошибка: {e.Message}");
    }
    finally
    {
        PrintMatrix(matrix); 
    }
}

int[,] MyMatrix = IntMatrix(5, 6, 1, 9);
MatrixCube(MyMatrix);

