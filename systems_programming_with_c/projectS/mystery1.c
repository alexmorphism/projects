/* mystery1.c */

int execlp(const char *file, const char *arg, ...);

int main(void) {
	close(0);

	open("storage0", 02100, 0660);

	execlp("cat", "cat", (char*)0);

	return 0;
}