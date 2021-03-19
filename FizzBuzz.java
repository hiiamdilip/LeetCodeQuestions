//Write a program that outputs the string representation of numbers from 1 to n.

//But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

//n = 15,

/*
Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        int i =1;
        List<String> list = new ArrayList<>();
        while(i<=n){
            if(i % 15 == 0) list.add("FizzBuzz");
            else if(i % 3 == 0) list.add("Fizz");
            else if(i % 5 == 0) list.add("Buzz");
            else list.add(String.valueOf(i));
            i++;
        }
        return list;
    }
}
