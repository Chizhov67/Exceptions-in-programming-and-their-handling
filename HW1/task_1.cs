int NumFromConsole(string userNumber)
{
    Console.Write($"Введите значение {userNumber}: ");
    int number = int.Parse(Console.ReadLine());
    return number;
}
int[] RandomArray(int size, int minValue, int maxValue)  
{
    int[] res = new int[size];

    for (int i = 0; i < size; i++)
    {
        res[i] = new Random().Next(minValue, maxValue + 1);
    }
    return res;
}
void Print (int[] point)  
{
  int digit = point.Length;
  for (int count = 0; count < digit; count++)
  {
      System.Console.Write(point[count] + " ");
  }
  return;
}
int[] Difference (int[] arr1, int[] arr2) 
{
    int[] ResArray = new int[arr1.Length];
    if (arr1.Length != arr2.Length)
    {
        System.Console.WriteLine("Длины массивов различны!");
    }
    else
    {
        for (int i = 0; i < arr1.Length; i++)
        {
            ResArray[i] = arr1[i] - arr2[i];
        }
        Print(ResArray);
    }
    return ResArray;
}
int numValue1 = NumFromConsole("size 1");
int numMinValue1 = NumFromConsole("min value");
int numMaxValue1 = NumFromConsole("max value");
int[] Array1 = RandomArray(numValue1, numMinValue1, numMaxValue1);
Print(Array1);
System.Console.WriteLine();

int numValue2 = NumFromConsole("size 2");
int numMinValue2 = NumFromConsole("min value");
int numMaxValue2 = NumFromConsole("max value");
int[] Array2 = RandomArray(numValue2, numMinValue2, numMaxValue2);
Print(Array2);
System.Console.WriteLine();

Difference (Array1, Array2);
