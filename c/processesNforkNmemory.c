#include<unistd.h>
#include<stdlib.h>
#include<stdio.h>
#include<signal.h>
#include<string.h>
#include<sys/wait.h>

#define nCHILDREN 7 

// a short program to display use of processes, fork, signals and malloc



int* mem = NULL;

void id(){
	printf( "PID[%d], child of PID[%d]\n", getpid(), getppid() );
	pause();
}

void leak(){
	mem = malloc(10*sizeof(int));
	if (mem == NULL){
	        perror("mem is safe;\n");
        }       

       else {  
	       printf(" . ");
       }
}

void reclaim(){
	free(mem);
	if(mem == NULL){ printf("Stolen memory has been claimed back.\n");
	}	
}


int main(int argc, char* argv[]){

	int n;
	int ticket = 1;
	printf("Once upon a time, lived %d greedy processes who leaked memory...\n",nCHILDREN);
	
	for (n=0; n<nCHILDREN; n +=1){
		if ( fork() == 0 ){
			printf("%d: ",ticket);
			leak();
			id();	
			exit(0);
		}
		
		ticket +=1;
		sleep(1);
	}

	printf("But not for long.\n");
	printf("Indeed, back in main() stood PID[%d] \n",getpid());
	for (n=5; n>0; n--){
		printf("%d ",n);
		sleep(1);
		printf("\n");
	}

	for (n=0; n<nCHILDREN; n++){
		printf("BANG. [%d] went down (kill returned %d)\n",getpid()+n+1, kill(getpid()+n+1, 9));
	}
	reclaim();

	printf("THE END.\n");
}
