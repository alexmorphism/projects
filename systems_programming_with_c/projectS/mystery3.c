/* mystery3.c */

int execlp(const char *file, const char *arg, ...);

int main(void) {

	close(0);
	close(1);

	if(fork() > 0){
		open("storage0", 02100, 0660);
		open("storage1", 02101, 0660);
	}
	else {
		open("storage1", 02100, 0660);
		open("storage0", 02101, 0660);
	}

	execlp("cat", "cat", (char*)0);

	return 0;
}