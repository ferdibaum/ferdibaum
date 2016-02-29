
#include <stdio.h>


// test test test
//more test more test

int main(void) {

	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);

	int x = 0;
	int y = 0;
	char zeichen;
	int ergeb = 0;
	printf("Rechner: \n");
	printf("Geben sie eine Zahl ein: \n");
	scanf("%3d", &x);
	printf("Geben sie eine zweite Zahl ein: \n");
	scanf("%3d", &y);
	printf("Geben sie ein Rechenzeichen ein: \n");
	scanf(" %c", &zeichen);

	if(zeichen == '+'){
		ergeb = x + y;
	} else if(zeichen == '-'){
		ergeb = x - y;
	} else if(zeichen == '/'){
		ergeb = x / y;
	}else if(zeichen == '*'){
		ergeb = x * y;
	}else{
		printf("Keine gültige Eingabe.\n");
		return -1;
	}
	printf("Das Ergebnis ist: %d\n", ergeb);

	return 0;
}
