int[] SumTwoArrays(int[] arr1, int[] arr2) 
{
    int[] ResArray = new int[arr1.Length];
    try
    {
        if (arr1.Length != arr2.Length)
        {
            throw new Exception("Длины массивов различны!");
        }
        else
        {
            for (int i = 0; i < arr1.Length; i++)
            {
                ResArray[i] = arr1[i] + arr2[i];
            }
            Print(ResArray);
        }
    }
    catch (Exception e)
    {
        Console.WriteLine($"Ошибка: {e.Message}");
    }
    return ResArray;
}