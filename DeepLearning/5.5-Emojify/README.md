# Emojify!

- We have always wanted to make our text messages more expressive? 

- Our emojifier app will help us to do that. 

- So rather than writing "Congratulations on the promotion!  Let's get coffee and talk. Love you!"  the emojifier can automatically turn this into "Congratulations on the promotion! 👍 Lets get coffee and talk. ☕️ Love you! ❤️"

- We will implement a model which inputs a sentence (such as "Let's go see the baseball game tonight!") and finds the most appropriate emoji to be used with this sentence (⚾️). 

-  In many emoji interfaces, We need to remember that ❤️ is the "heart" symbol rather than the "love" symbol. 

- Using word vectors, we'll see that even if our training set explicitly relates only to a few words in a particular emoji, Our algorithm will be able to generalize and associate words in the test set to the same emoji even if those words don't even appear in the training set. 

- This allows us to build an accurate classifier mapping from sentences to emojis, even using a small training set.

- In this exercise, we'll start with a baseline model (Emojifier-V1) using word embeddings, then build a more sophisticated model (Emojifier-V2) that further incorporates an LSTM.

