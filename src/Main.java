import java.util.Scanner;
public class Main {

    public static void createArr(Abiturient[] arr, int count){
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < count; i++){
            arr[i] = new Abiturient();

            System.out.print("\nВведіть ID: ");
            arr[i].setId(scan.nextInt());
            scan.nextLine();

            System.out.print("Введіть прізвище: ");
            arr[i].setSurname(scan.nextLine());

            System.out.print("Введіть ім'я: ");
            arr[i].setName(scan.nextLine());

            System.out.print("Введіть по-батькові: ");
            arr[i].setPatronymic(scan.nextLine());

            System.out.print("Введіть адресу: ");
            arr[i].setAddress(scan.nextLine());

            System.out.print("Введіть телефон: ");
            arr[i].setTelephone(scan.nextLine());

            System.out.print("Введіть середній бал: ");
            arr[i].setAvgScore(scan.nextDouble());
            scan.nextLine();
        }
    }

    public static void compareName(Abiturient[] arr, int count, String name){
        System.out.print("Абітурієнти з іменем " + name + ": ");

        int k = 0;

        for(int i = 0; i < count; i++){

            if (name.equalsIgnoreCase(arr[i].getName())){
                System.out.print(arr[i]);
                k++;
            }
        }
        if (k == 0) {
            System.out.print("Немає");
        }
    }

    public static void compareScore(Abiturient[] arr, int count, double score){

        System.out.print("Абітурієнти з більшим балом за " + score + ": ");
        int k = 0;
        for(int i = 0; i < count; i++){

            if (arr[i].getAvgScore() > score){
                System.out.print(arr[i]);
                k++;
            }
        }
        if (k == 0) {
            System.out.print("Немає");
        }
    }

    static void swap(Abiturient[] arr, int i, int j){
        Abiturient temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(Abiturient[] arr, int low, int high){
        double pivot = arr[high].getAvgScore();
        int i = (low - 1);
        for(int j = low; j < high ; j++) {
            if (arr[j].getAvgScore() < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(Abiturient[] arr, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void bestAbiturient(Abiturient[] arr, int count, int n){
        quickSort(arr, 0, count - 1);
        for(int i = 0; i < n; i++){
            System.out.print(arr[count-i-1]);
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.print("Введіть кількість абітурієнтів: ");
        int count = scan.nextInt();
        scan.nextLine();

        Abiturient[] arr = new Abiturient[count];
        createArr(arr, count);

        System.out.print("\nВведіть ім'я абітурієнта для пошуку: ");
        String name = scan.nextLine();
        compareName(arr, count, name);

        System.out.print("\n\nВведіть бал абітурієнта для пошуку більших: ");
        double score = scan.nextDouble();
        compareScore(arr, count, score);

        System.out.print("\n\nВведіть кількість найкращих студентів за середнім балом: ");
        int n = scan.nextInt();
        bestAbiturient(arr, count, n);
    }
}
