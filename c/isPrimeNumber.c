#include<stdio.h>

/* displays natural dividers of prime n */
int getPrimeNbOfN(int* n){

  int i=2;
  int temp = *n;

  while (temp != 1) {

    while ((temp % i) == 0){
      printf("%5d | %5d\n", temp, i);
      temp = temp / i;
    }
    i +=1;

  }

}


/* test if n has natural dividers */
int isPrime(int* n){

  int i=2;
  while (i < *n) {

    if (*n % i == 0){
      //printf("false: %d | %d\n", i, *n);
      return 0;
    }

    else {
      i +=1;
    }

  }

  //printf("true\n");


  return 1;
}


int main(int argc, char* argv[]){

  // check if command has exactly ONE input argument
  if ( argc != 2) {
    printf("usage: %s <int>\n", argv[0]);
    return 2;
  }

  //
  int res = atoi(argv[1]);
  if (isPrime(&res) == 0){
    printf("false\n");
    getPrimeNbOfN(&res);
  }
  else {
    printf("true\n");
  }
}
