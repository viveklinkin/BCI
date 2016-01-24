#include<iostream.h>
#include<conio.h>
#include<stdlib.h>

int winflag = 0;
int turn = 1;

void disp(int b[6][7]) {
	clrscr();
	int i, j;
	cout << endl;
	cout << "0 1 2 3 4 5 6\n";
	for (i = 0; i < 6; i++) {
		cout << endl;
		for (j = 0; j < 7; j++)
			cout << b[i][j] << " ";
	}
}

void drop(int b[6][7], int pos) {
	int x, i;
	if (turn == 1)
		x = 1;
	else
		x = 2;
	for (i = 5; i >= 0; i--)
		if (b[i][pos] == 0) {
			b[i][pos] = x;
			break;
		}
}
int check(int b[6][7]) {
	int i, j;
	for (i = 0; i < 6; i++)
		for (j = 0; j < 4; j++)
			if (b[i][j] == b[i][j + 1] && b[i][j] == b[i][j + 2]
					&& b[i][j] == b[i][j + 3] && (b[i][j] == 1 || b[i][j] == 2))
				return 1;
	for (i = 0; i < 3; i++)
		for (j = 0; j < 7; j++)
			if (b[i][j] == b[i + 1][j] && b[i][j] == b[i + 2][j]
					&& b[i][j] == b[i + 3][j] && (b[i][j] == 1 || b[i][j] == 2))
				return 1;
	for (i = 3; i < 6; i++)
		for (j = 0; j < 4; j++)
			if (b[i][j] == b[i - 1][j + 1] && b[i][j] == b[i - 2][j + 2]
					&& b[i][j] == b[i - 3][j + 3]
					&& (b[i][j] == 1 || b[i][j] == 2))
				return 1;
	for (i = 0; i < 3; i++)
		for (j = 0; j < 4; j++)
			if (b[i][j] == b[i + 1][j + 1] && b[i][j] == b[i + 2][j + 2]
					&& b[i][j] == b[i + 3][j + 3]
					&& (b[i][j] == 1 || b[i][j] == 2))
				return 1;
	int flag = 0;
	for (i = 0; i < 6; i++)
		for (j = 0; j < 7; j++)
			if (b[i][j] == 0)
				flag = 1;
	if (flag == 0) {
		disp(b);
		int k;
		for (i = 0, k = 3; i < 3 && k < 6; i++, k++)
			for (j = 0; j < 7; j++)
				b[k][j] = b[i][j];
		for (i = 0; i < 3; i++)
			for (j = 0; j < 7; j++)
				b[i][j] = 0;
		cin.get();
	}
	return 0;
}
int* init(int b[6][7]) {
	int i, j;
	for (i = 0; i < 6; i++)
		for (j = 0; j < 7; j++)
			b[i][j] = 0;
	for(i=0;i<7;i++)
		h[i]=100;
	return h;
}

int* heuristic(int a[6][7], int player,int player2) {
	int sum, i, j, b[6][7], k,val=100;
	for (i = 0; i < 6; i++)
		for (j = 0; j < 7; j++) {
			if (a[i][j] == 2)
				b[i][j] = 5;
			else
				b[i][j] = a[i][j];
		}
	if (player == -1)
		player = 5;
	for (i = 0; i < 7; i++)
		h[i] = val;
	for (i = 0; i < 6; i++) {

		sum = 0;
		for (j = 0; j < 4; j++) {
			sum = b[i][j] + b[i][j + 1] + b[i][j + 2] + b[i][j + 3];
			if (sum == 3 * player || sum==3*player2) {
				if(sum==player2*3)
				val=50;
				if(i==6){
				for (k = 0; k < 4; k++) {
			if (a[i][j+k] == 0)
						h[j+k] += val;
				}
				}
				else
					for(k=0;k<4;k++){
						if(a[i][j+k]==0 &&a[i+1][j+k]!=0)
							h[j+k]+=val;
						else if(a[i][j+k]==0 && a[i+1][j+k]==0)
							h[j+k]-=val;
					}
			}sum=0;
		}
	}

	for (i = 0; i < 3; i++) {

		for (j = 0; j < 7; j++) {
			sum = b[i][j] + b[i + 1][j] + b[i + 2][j] + b[i + 3][j];
			if (sum == 3 * player || sum == 3*player2) {
				if(sum==3*player2)
					val=50;
				h[j] += val;
			}
			sum=0;
		}
	}
	val=100;
	for (i = 3; i < 6; i++) {
		for(j=0;j<4;j++){
		sum=b[i][j]+b[i-1][j+1]+b[i-2][j+2]+b[i-3][j+3];
		if(sum== 3*player|| sum==3*player2)
		{	if(sum==3*player2)
				val=50;
			if(i!=5)
		{
			for(k=0;k<4;k++)
				if(b[i-k][j+k]==0 && b[i-k+1][j+k]!=0)
					h[j+k]+=val;
				else if(a[i-k][j+k]==0 && a[i-k+1][j+k]==0)
										h[j+k]-=val;
		}	else
		{	if(b[i][j]==0)
			h[j]+=val;
			else
			{
			for(k=1;k<4;k++)
			if(b[i-k][j+k]==0 && b[i-k+1][j+k]!=0)
				h[j+k]+=val;	else if(a[i-k][j+k]==0 && a[i-k+1][j+k]==0)
					h[j+k]-=val;
			}
			}
		}
		sum=0;
	}
	}
	val=100;
	for(i=0;i<3;i++){
		for(j=0;j<4;j++){
			sum=b[i][j]+b[i+1][j+1]+b[i+2][j+2]+b[i+3][j+3];
			if(sum==3*player||sum==player2*3){
				if(sum==player2*3)
					val=50;
				if(i+3!=5){
				for(k=0;k<4;k++)
					if(b[i+k][j+k]==0 && b[i+k+1][j+k]!=0)
						h[j+k]+=val;	else if(a[i+k][j+k]==0 && a[i+k+1][j+k]==0)
							h[j+k]-=val;
				}
				else{
				if(b[i+3][j+3]==0)
					h[j+3]+=val;
				else
				{
					for(k=0;k<3;k++)
						if(b[i+k][j+k]==0 && b[i+k+1][j+k]!=0)
							h[j+k]+=val;	else if(a[i+k][j+k]==0 && a[i+k+1][j+k]==0)
								h[j+k]-=val;
				}
				}
			}
		sum=0;
		}

	}
	return h;
}
int max(int a[7]) {
int i=0, max = a[0],pos=0; int x[7];
for (i = 0; i < 7; i++) {
	if (max < a[i])
		{
		max = a[i];

		}
}
int k=0;
for(i=0;i<7;i++)
if(a[i]==max){
x[k]=i;k++;}
pos=rand()%k;
return x[pos];
}

int main() {
srand((int) time(0));
int pos;
int b[6][7];
int h[7];
h=init(b);
while (winflag == 0) {
	label: disp(b);
	cout << "\nEnter the position to drop coin player";
	if (turn == 1) {
		cout << " 1\n";
		cin >> pos;
	} else {
		cout << " 2\n";
		h=heuristic(b,turn,turn*-1);
		for(int l=0;l<7;l++)
		cout<<endl<<h[l];
		getch();
		pos = max(h);
	}
	if (b[0][pos] != 0 && pos >= 0 && pos <= 6) {
		cout << "Invalid position";
		cin.get();
		goto label;
	}
	drop(b, pos);
	if (check(b) == 1) {
		disp(b);
		cout << "Player ";
		if (turn == 1)
			cout << " 1 ";
		else
			cout << " 2 ";
		cout << " wins";
		cin.get();
		winflag = 1;
	}
	turn *= -1;
}

return 0;
}
