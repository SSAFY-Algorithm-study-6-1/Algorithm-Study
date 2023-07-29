#include <algorithm>
#include <vector>
#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

typedef struct
{
	int x;
	int y;
	int z;
}point;

int M, N, H;
int arr[101][101][101];

int dz[] = { -1,1,0,0,0,0 };
int dx[] = { 0,0,0,0,-1,1 };
int dy[] = { 0,0,-1,1,0,0 };

int SOLVE;

void bfs()
{
	queue<point> q;

	for (int h = 0; h < H; h++)
	{
		for (int y = 0; y < N; y++)
		{
			for (int x = 0; x < M; x++)
			{
				if (arr[h][y][x] > 0)
					q.push({ x,y,h });
			}
		}
	}

	while (!q.empty())
	{
		auto currnode = q.front();
		q.pop();

		int currx = currnode.x;
		int curry = currnode.y;
		int currz = currnode.z;

		for (int d = 0; d < 6; d++)
		{
			int nextx = currnode.x + dx[d];
			int nexty = currnode.y + dy[d];
			int nextz = currnode.z + dz[d];
			
			if (nextx < 0 || nextx >= M || nexty < 0 || nexty >= N || nextz < 0 || nextz >= H)
				continue;
			if (arr[nextz][nexty][nextx] != 0)
				continue;
			arr[nextz][nexty][nextx] = arr[currz][curry][currx] + 1;
			q.push({ nextx,nexty,nextz });
		}
	}

	int max = 0;
	bool solved = true;
	for (int h = 0; h < H; h++)
	{
		for (int y = 0; y < N; y++)
		{
			for (int x = 0; x < M; x++)
			{
				if (arr[h][y][x] > max)
					max = arr[h][y][x];
				if (arr[h][y][x] == 0)
					solved = false;
			}
		}
	}

	if (solved)
		cout << max - 1 << endl;
	else
		cout << -1 << endl;

}

int main()
{
	memset(arr, 0, sizeof(arr));

	cin >> M >> N >> H;

	for (int h = 0; h < H; h++)
	{
		for (int y = 0; y < N; y++)
		{
			for (int x = 0; x < M; x++)
			{
				cin >> arr[h][y][x];
			}
		}
	}
	bfs();
}