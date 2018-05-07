Name: Sandhya, 83

#include <iostream>
using namespace std;
void Mergesort(int[],int);

void Merge(int L[],int R[],int A[],int nl,int nr)
{
    int i,j,k;
    i=j=k=0;
    while(i<nl && j<nr)
    {
        if(L[i]<=R[j])
        {
            A[k]=L[i];
            k++;
            i++;
        }
        else
        {
            A[k]=R[j];
            k++;
            j++;
        }
    }
    while(i<nl)
    {
        A[k]=L[i];
        i++;
        k++;
    }
    while(j<nr)
    {
        A[k]=R[j];
        j++;
        k++;
    }

}

void Mergesort(int A[],int n)
{
    if(n<2)
        return;
    int mid=n/2;
    int left[mid],right[n-mid];
    for(int i=0; i<mid; i++)
        left[i]=A[i];
    for(int i=mid; i<n; i++)
        right[i-mid]=A[i];
    Mergesort(left,mid);
    Mergesort(right,n-mid);
    Merge(left,right,A,mid,n-mid);
}


int main()
{
    int arr[100];
    int n;
    cin>>n;
    for(int i=0; i<n; i++)
        cin>>arr[i];
    Mergesort(arr,n);
    for(int i=0; i<n; i++)
        cout<<arr[i]<<endl;
}
