public class Main {

    public static void main(String args[])
    {
        String str = "Hello World!";
        int[] arr = {1, 2, 3, 5, 8, 13};
        int key = Integer.parseInt(args[0]);
        switch(key){
            case 0: System.out.println(str); break;
            case 1: case 2: System.out.println(str.replace("o", "oo")); break;
            default:
                if (key > ++arr[arr.length-1]){
                    for (int each: arr){
                        str = str.replace("o", "oo");
                    }
                }
                else {
                    while(key < arr[arr.length-1]*2){
                        for (int i = 0; i < arr.length-1; i++) {
                            key += arr[i];
                            str = str.replace("l", "ll");
                        }
                    }
                }
                System.out.println(str);
        }
    }
}