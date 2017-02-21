from random import choice
from random import randint

#Part 1

no1 = eval(input("Input a series of numbers including some zeroes: "))

print(no1[-1])
print(no1[0:3])
print(no1[1:len(no1)-1])
print(len(no1))
if 5 in no1:
    print("Yes")
else:
    print("No")

print(no1.count(5))
print(no1[::-1])


#Part 2

quotes = ["Sweater.", "Live with it.", "Nope.", "Dog's Blood"]

print(choice(quotes))

#Part 3
random = [0]

#for i in range(0, 1, 20):
#   random2[] = randint(1, 100)
#   random = random + random2

print(random)

#Part 4

no2 = eval(input("Input a list of values with no repeats: "))

print("Average: ", sum(no2) / len(no2))
print(max(no2))
print(min(no2))
print(max(no2))

#Part 5

no3 = eval(input("Input a list of integers: "))

if 0 in no3:
    print(no3.index(0))
else:
    print("No zeroes here.")


#PArt 6
for i in range(0, 1, 20):
    random[i] = randint(0,1)
    
print(random)
