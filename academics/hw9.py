#Part 1

def average(list1):
    no1 = 0
    no2 = 0
    no3 = 0

    for i in range(0, len(list1)):
        no1 = no1 + list1[i]

    no2 = no1/len(list1)

    return(no2)


#Part 2
def count_greater_than(list1, n):
    no1 = 0

    for i in range(0, len(list1)):
        if list1[i] > n:
            no1 = no1 + 1

    return(no1)

#Part 3

#def wordlist_begin(a, start):


#Part 4

def random_letter():
    from random import choice
    alphabet = ["A", "B", "C", "D", "E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]

    z = choice(alphabet)
    return(z)
#Not entirely sure what I did wrong here. It almost looks like it's giving the physical address instead of the actual letter.

#Part 5
def last_word(string):
    last = string.split()[-1]
    return(last)

#Part 6
def numerical_value(string2):
    no3 = 0
    no4 = ""
    finalval = 0
    f = ""
    j = 0
    alpha = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    ordin = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26]
    for i in range(0, len(string2)):
        no4 = string2[i]
        for j in range(0, 26):
            f = alpha[j]
            no5 = ordin[j]
            no6 = j
            if f == string2[i]:
                continue
            finalval = finalval + no5

    return(finalval)
        
#It half-works, at least it gives a value, but I have no idea what I did wrong.
#I basically attempted to get it to assign values to the alpha through the use of two lists
#Where the final value is 'val'+ the number at ordin[j]

#Part 7
def one_away(string3, string4):
    sim = 0
    if len(string3) != len(string4):
        return("False")
    elif len(string3) == len(string4):
        for i in range(0, len(string3)):
            no1 = string3[i]
            no2 = string4[i]
            if no1 != no2:
                sim = sim - 1

    if sim == -1:
        return("True")
    if sim != -1:
        return("False")

#Part 8

def smallest_missing(list3):
    no7 = 1
    for i in range(0, len(list3)):
        if list3[i] < no7:
            no7 = no7
        if list3[i] == no7:
            no7 = no7+1
        if list3[i] > no7:
            no7 = no7
        return(no7)
