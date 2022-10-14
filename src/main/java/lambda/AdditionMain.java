package lambda;

public class AdditionMain {
    public static void main(String[] args) {
        Addition addition = new Addition() {

            //익명 클래스(어나니머스 클래스)

            @Override
            public int add(int[] numbers) {
                int result = 0;
                for (int num : numbers){
                    result += num;
                }
                return result;
            }
        };

        int result1 = addition.add(new int[]{1,2,3,4,5,6,7,8,9,10});
        System.out.println("결과1 : " + result1);
    }
}
