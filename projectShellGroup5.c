#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <pthread.h>

#define TRUE 1
#define INPUT_SIZE 256
#define STRING_ARRAY_SIZE 80

void batch(FILE * f) 
{
  long length;

  if (f == NULL) 
  {
    perror("Unable to open the file");
    exit(1);
  }
  
  char line[INPUT_SIZE];

  while (fgets(line, INPUT_SIZE, f)) 
    system(line);

  exit(0);
}

void* executeCommand(void* ptr)
{
  char* command;
  command = (char*) ptr;
  char * args[STRING_ARRAY_SIZE];          //where arguments will be from input
  int i = 0;
  char * words = strtok(command, " ");

  while (words != NULL) 
  {
    args[i++] = words;
    words = strtok(NULL, " ");
  }
  args[i] = NULL;

  int rc = fork();
  if (rc == 0) 
  {
    execvp(args[0], args);
    perror("Error: exec");
    exit(0);
  }
  else if (rc == -1) 
    perror("fork");
  else 
    wait(0);
}

int main(int argc, char const * argv[]) 
{
  char * commandsArray[STRING_ARRAY_SIZE];  //array for ;
  char input[INPUT_SIZE];                   //input at interactive
  
  if (argv[1] != NULL) 
    batch(fopen(argv[1], "rb"));

  while (TRUE) 
  {
    printf("myShell-Group5>");
    fflush(stdout);

    char *s = gets(input);

    if (strcmp(input, "") == 0) 
      break; 
    if(s == NULL)
      break;

    int j = 0;
    if (strchr(input, ';')) 
    {
      char * commands = strtok(input, ";");
      while (commands != NULL) 
      {
        commandsArray[j++] = commands;
        commands = strtok(NULL, ";");
      }
    }

    if (j == 0) 
      executeCommand(input);

    pthread_t tId[j + 1];

    for (int k = 0; k < j; k++) 
      pthread_create(&tId[k], NULL, executeCommand, (void*)commandsArray[k]);

    for (int l = 0; l < j; l++) 
      pthread_join(tId[l], NULL);
  }

  printf("\nClosing shell\n");
   exit(0); 
  return 0;
}
