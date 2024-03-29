// Example 1:

// Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
// Output: "c"
// Explanation: The keypresses were as follows:
// Keypress for 'c' had a duration of 9 (pressed at time 0 and released at time 9).
// Keypress for 'b' had a duration of 29 - 9 = 20 (pressed at time 9 right after the release of the previous character and released at time 29).
// Keypress for 'c' had a duration of 49 - 29 = 20 (pressed at time 29 right after the release of the previous character and released at time 49).
// Keypress for 'd' had a duration of 50 - 49 = 1 (pressed at time 49 right after the release of the previous character and released at time 50).
// The longest of these was the keypress for 'b' and the second keypress for 'c', both with duration 20.
// 'c' is lexicographically larger than 'b', so the answer is 'c'.

// Method 1:
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Integer> map = new HashMap<>();
        int max = releaseTimes[0];
        char result='j';
        int value =0;
        for(int i =0; i< releaseTimes.length; i++){
            if(map.containsKey(keysPressed.charAt(i))){
                value = map.get(keysPressed.charAt(i));
                value = value>(releaseTimes[i] - releaseTimes[i-1]) ? value: releaseTimes[i] - releaseTimes[i-1];
                map.put(keysPressed.charAt(i), value);
            }else{
               if(i == 0){
                   value = releaseTimes[i];
               }
                else{
                   value =  releaseTimes[i] - releaseTimes[i-1];
                }
               map.put(keysPressed.charAt(i), value); 
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() >= max){
                max = entry.getValue();
                result = entry.getKey();
            } 
        }
        return result;
    }
}

// Method 2:
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
       char slowestKey = keysPressed .charAt(0);
       int maxDuration =0;
       int lastRelease = 0;
        for(int i =0;i<releaseTimes.length; i++){
            int duration = releaseTimes[i] - lastRelease;
            if(duration > maxDuration){
                maxDuration = duration;
                slowestKey = keysPressed .charAt(i);
            } else if(duration == maxDuration){
                slowestKey = (keysPressed.charAt(i) - slowestKey) > 0 ? keysPressed.charAt(i) : slowestKey;
            }
            lastRelease = releaseTimes[i];
        }
        return slowestKey;
    }
}
