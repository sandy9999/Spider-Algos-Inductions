#include <iostream>
using namespace std;
int a[65][65];

int modify(int rst,int rend,int cst,int cend,int size,float limit)
{
    if(size==1)
        return a[rst][cst];
    else
    {
        int topright = modify(rst+size/2,rend,cst,cst+size/2-1,size/2,limit);
        int topleft = modify(rst,rst+size/2 - 1,cst,cst+size/2-1,size/2,limit);
        int bottomright = modify(rst+size/2,rend,cst+size/2,cend,size/2,limit);
        int bottomleft = modify(rst,rst+size/2 - 1,cst+size/2,cend,size/2,limit);
        int ct1 = (topright + topleft + bottomright + bottomleft);
        if(((ct1*100)/float(size*size)) >= limit)
        {
            for(int i=rst; i<=rend; i++)
            {
                for(int j=cst; j<=cend; j++)
                {
                    a[i][j] = 1;
                }
            }
        }
        else if(((ct1*100)/float(size*size)) <= (100-limit))
        {
             for(int i=rst; i<=rend; i++)
            {
                for(int j=cst; j<=cend; j++)
                {
                    a[i][j] = 0;
                }
            }
        }
        
        return ct1;
            
    }
}


int main() {
	// your code goes here
	int ct=1;
	while(1)
	{
	int w;
	float t;
	cin>>w;
	if(w==0)
	    break;
	cin>>t;
	for(int i=0; i<w; i++)
	{
	    char c[67];
	    cin>>c;
	    
	    for(int j=0; j<w; j++)
	        a[i][j] = c[j]-'0';
	}
	    
	modify(0,w-1,0,w-1,w,t);
	cout<<"Image "<<ct<<":\n";
	ct++;
	for(int i=0; i<w; i++)
	{
	    for(int j=0; j<w; j++)
	        cout<<a[i][j];
	    cout<<endl;
	}
	}
	return 0;
}
