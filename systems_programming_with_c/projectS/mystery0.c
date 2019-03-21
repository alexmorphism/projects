/* mystery0.c */

int execlp(const char *file, const char *arg, ...);

int main(void) {

	close(1);

	open("storage0", 02101, 0660);

	execlp("./hello42", "./hello42", (char*)0);

	return 66;
}