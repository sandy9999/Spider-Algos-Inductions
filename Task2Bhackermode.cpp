#include <bits/stdc++.h>
using namespace std;
vector<pair<string,int> > f;
map <char,int> key;
map <int,char> m;
stack <pair<bool,string> > modify;//0 for add, 1 for remove

struct TrieNode
{
    struct TrieNode *children[53];
    int isWordEnd;
};

struct TrieNode *getnode(void)
{
    struct TrieNode *pNode = new TrieNode;
    pNode->isWordEnd = 0;
    for(int i=0; i<53; i++)
        pNode->children[i] = NULL;
    return pNode;
}

void add(struct TrieNode *root, string word)
{
    struct TrieNode *pCrawl = root;
    int l = word.length();
    for(int i=0; i<l; i++)
    {   
        if(!pCrawl->children[key[word[i]]])
            pCrawl->children[key[word[i]]] = getnode();
        pCrawl = pCrawl->children[key[word[i]]];
    }
    (pCrawl->isWordEnd)++;
}
//removes may have bugs
void removes(struct TrieNode *root,string word)
{
    struct TrieNode* pCrawl = root;
    int l = word.length();
    for(int i=0; i<l; i++)
    {
        if(pCrawl->children[key[word[i]]]!=NULL)
            pCrawl = pCrawl->children[key[word[i]]];
    }
    pCrawl->isWordEnd = 0;
}

bool isLastNode(struct TrieNode* root)
{
    for(int i=0; i<53; i++)
        if(root->children[i])
            return 0;
    return 1;
}

void dfs(struct TrieNode* root,string newprefix)
{
    if(root->isWordEnd)
    {
        f.push_back(make_pair(newprefix,root->isWordEnd));
    }
    if(isLastNode(root))
        return;
    for(int i=0; i<53; i++)
    {
        if(root->children[i])   
        {
            newprefix.push_back(m[i]);
            dfs(root->children[i],newprefix);
            newprefix.pop_back();
        }
        
    }
    
}

bool compare(const pair<string,int>&i, const pair<string,int>&j)
{
    return i.second>j.second;
}

bool query(struct TrieNode *root, string prefix)
{
    struct TrieNode* pCrawl = root;
    for(int i=0; i<prefix.length(); i++)
    {
        if(pCrawl->children[key[prefix[i]]]==NULL)
            return 0;
        pCrawl = pCrawl->children[key[prefix[i]]];
    }
    string newprefix = prefix;
    f.clear();
    dfs(pCrawl,newprefix);
    sort(f.begin(),f.end(),compare);
    if(f.size()>=5)
    {
        for(int i=0; i<5; i++)
            cout<<f[i].first<<'\n';
    }
    else
    {
        int l = f.size();
        for(int i=0; i<l; i++)
            cout<<f[i].first<<'\n';
    }
    return 1;
}

int main()
{
    for(int i=0; i<26; i++)
    {
        key['a'+i] = i;
        m[i] = 'a' + i;
    }
    for(int i=26; i<52; i++)
    {
        key['A'+i-26] = i;
        m[i] = 'A' + i - 26;
    }
    key[' '] = 52;
    m[52] = ' ';
    int n;
    cin>>n;
    struct TrieNode* root = getnode();
    cin.get();
    //cout<<"hello\n";
    while(n--)
    {   
        string b;
        getline(cin,b);
        add(root,b);
        //cout<<b<<endl;
    }
    int q;
    cin>>q;
    while(q--)
    {
        string a,b;
        cin>>a;
        cin.get();
        //cout<<a<<endl<<b<<endl;
        if(a.compare("add")==0)
        {
            getline(cin,b);
            add(root,b);
            modify.push(make_pair(0,b));   
        }
        else if(a.compare("remove")==0)
        {
            getline(cin,b);
            removes(root,b);
            modify.push(make_pair(1,b));
        }
        else if(a.compare("query")==0)
        {
            getline(cin,b);
            query(root,b);
        }
        else if(a.compare("revert")==0)
        {
            int c;
            cin>>c;
            for(int i=0; i<c; i++)
            {
                //cout<<modify.top().first<<endl;
                if(modify.top().first==0)
                    removes(root,modify.top().second);
                else
                    add(root,modify.top().second);
                modify.pop();
            }
        }
    }
    return 0;
}
