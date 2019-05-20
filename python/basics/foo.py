from random import randint
from time import sleep


def matchGame():

    def player(res):
        pick = False
        while(pick==False):
            try:
                n=int(input('how many will you take:\t'))
                if((n<=5) and (n>=1)):
                    pick = True
                    return n

                else:
                    print('you cannot pick more than 5 matches.')

            except ValueError:
                print('you must enter a number, genius.')

    def ia(res):
        n=randint(1,5)
        print('ia plays and picks',n,'matches')
        return n

    #amount of matches
    res=randint(1,100)
    print('There are',res,'matches;\nthe one who takes the last one loses.\nYou can not pick more than 5.')

    coinFlip = randint(1,2)
    if(coinFlip==1):
        print('\nYour turn.')
        while(res>0):
            n = player(res)
            res -= n
            if(res>0):
                print(res,'left')
            else:
                print('you picked the last one; you lost.')
                return

            n = ia(res)
            res -=n
            if(res>0):
                print(res,'left')
            else:
                print('IA picked the last one; you won.')
                return

    else:
        print('IA begins')
        while(res>0):
            n = ia(res)
            res -=n
            if(res>0):
                print(res,'left')
            else:
                print('IA picked the last one; you won.')
                return

            n = player(res)
            res -= n
            if(res>0):
                print(res,'left')
            else:
                print('you picked the last one; you lost.')
                return

#input validation, try/except -
def inputValidation():
    try:
        n=int(input('type your age:\t'))
        lim = 18
        if(n>lim):
            print('Welcome to WestWorld.')
        elif(n == 0):
            print('Weird. You look older than 0 year old')
        elif(n == (lim-1)):
            print('Come back next year, kiddo.')

        else:
            print('You should find activities of your age, kiddo.')
    except ValueError:
            print('you must enter an number, genius.')

def divAbyB(a,b):
    try:
        return a/b
    except ZeroDivisionError:
        return 'error: you tried a div by zero '

# recursivité -----------------
def fact(n):
    if(n==0):
        return 1
    else:
        return n*fact(n-1)

def fibonacci(i,n):
    sleep(0.1)
    if(i==0):
        print(1)
        print(2)
        return fibonacci(1, 2)

    elif(i==1):
        res = i+n
        print(res)
        return fibonacci(n, res)

    elif(n<1000):
        res = i+n
        print(res)
        return fibonacci(n,res)

# basics --------------------
def gaussian(n):
    res = 0
    for i in range(101):
        res +=i
    return res

def displayDelta(n):
    res = ''
    for i in range(n):
        sleep(0.01)
        res += '.'
        print(res)

def growNShrink(n):
    res = []
    for i in range(n):
        sleep(0.1)
        res.append(i)
        print(res)

    temp=n-1
    for i in range(n):
        #print('temp = ',temp)
        res.pop(temp)
        temp -= 1
        #print('temp = ',temp)
        print(res)

# lists --------------------
def listExample():
    num = []
    for i in range(11):
        print(num)
        num.append(i)
    print(len(num))
