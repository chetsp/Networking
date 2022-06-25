#include<iostream>
using namespace std;
void bin(int array[],int no)
{
	int count=0;
	while(no!=0)
	{
		array[4-count]=no%2;
		count++;
		no/=2;
	}
	while(count!=5)
	{
		array[4-count]=0;
		count++;
	}

}
void mat_multiply(int code[],int data[],int matrix[][7])
{
	for(int i=0;i<1;i++)
		for(int j=0;j<7;j++)
		{
			code[j]=0;
			for(int k=0;k<4;k++)
			if(data[k]*matrix[k][j]==code[j])
				code[j]=0;
			else code[j]=1;
		}		
}
int main()
{
	int matrix[4][7]={{1,0,0,0,1,1,1},{0,1,0,0,0,1,1},{0,0,1,0,1,1,0},{0,0,0,1,1,0,1}};
	int codeword[7];
	int dataword[4];
	cout<<"dataword\tcodeword\n";
	for(int i=0;i<16;i++)
	{
		bin(dataword,i);
		mat_multiply(codeword,dataword,matrix);
		for(int j=0;j<4;j++)
		cout<<dataword[j];
		cout<<"\t\t";
		for(int j=0;j<7;j++)
		cout<<codeword[j];
		cout<<endl;
	}
	return 0;
}
