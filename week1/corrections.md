# Study Week 1 MC Corrections

### Question 10
![a](https://cdn.discordapp.com/attachments/966012246931173416/966012252350206012/unknown.png)

**Thought Process:** This one was a little confusing because I am not used to instantiating objects that use classes extended from another or implemented from an interface. However, by using some logic, I was able to arrive at the correct answer. Out of all the choices, D seemed to be the most incorrect because Student and Athlete have no relation to each other while the other answer choices do.

**Learning:** I watched the 9.5 daily video 1 (skill 3.A) to deepen my understanding a little bit. At the end, I learned that you can declare variables that point to a subclass. That’s how the inheritance hierarchy works. "The one on the right needs a 'is-a' relationship with the one on the left of the assignment". This screenshot proved helpful.
![a](https://cdn.discordapp.com/attachments/783082777020203061/968025459650617394/unknown.png)


### Question 12
![a](https://cdn.discordapp.com/attachments/966012246931173416/966013360493715576/unknown.png)
**Thought Process:** I knew this was a standard for loop that checks each character in the string from back to front. I originally thought that it was comparing the last 2 characters to the middle 2 characters and then those to the first 2 characters. 

**Learning:** After a little bit of thinking, I realized that this was just essentially reversing the string provided, and if the reversed string was equal to the original string, it returns true, otherwise false. Pretty simple and I'll probably get it right from now on.


### Question 13
![a](https://cdn.discordapp.com/attachments/966012246931173416/966013360493715576/unknown.png)
**Thought Process:** I was a little stumped on this one especially the line inside the for loop. I saw that it was changing the index and my brain started doing some gymnastics and then I lost it from there

**Learning:** Understanding why the answer is correct is more important than knowing that it's the correct answer. By discovering the pattern in the correct answer, I was able to reverse engineeer the algorithm inside the for loop. Basically, since it's only running this to every 3rd index (since k is 3), I have to focus on every 3rd element and see if it correctly added 3 to the integer. A is the only possible option. 


### Question 23
![a](https://cdn.discordapp.com/attachments/966012246931173416/966019893201875055/unknown.png)
**Thought Process:** I'm not the best at sorts so I half guessed on this question. 

**Learning:** Using the answer, I was able to figure out that insertion sorts always need to run n-1 times. n being the number of elements in the array. Therefore, on the second iteration, the first 3 elements should be sorted (least to greatest) and the rest shall still be the same as the original array. Answer choice C fits this criteria.


### Question 38
![a](https://cdn.discordapp.com/attachments/966012246931173416/968034936890212352/unknown.png)
**Thought Process:** At this point in the quiz, I was out of time so I put down a random question. I am now redoing the problem concurrently with corrections.

**Learning:** The first two if statements are kind of confusing as well as the recursiveness making the entire big idea a bit hard to grasp. But the hardest part of this is understanding the parameters. Once you understand what the parameters mean, the two if statements and else statements make a lot more sense. The first is checking if the current element equals the number, the second is a check for if the array is size 1, that means there has to only be ONE element equal to the value. The last else occurs when there are more than 1 elements and further checks are needed for the other elements using recursive functions.
