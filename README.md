## ListView

ListView는 스크롤 가능한 항목의 목록을 표시하는 뷰 그룹입니다. 목록 항목은 배열 또는 데이터베이스 쿼리와 같은 소스에서 콘텐츠를 가져와서 목록에 배치된 뷰로 각 항목 결과를 변환하는 **Adapter**를 사용하여 목록에 자동으로 삽입됩니다.


ListView 데이터를 연결하기위한 순서

1. 데이터 정의 datas로 정의함

	```java
	String datas[] = {"선택", "ListView", "GridView", "RecyclerView", "Custom"};
	```

2. 아답터 생성

	```java
	ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas);
	```

3. 뷰에 아답터 연결

	```java
	listview.setAdapter(adapter);
	```


```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listview = (ListView) findViewById(R.id.listView);
        // 1. 데이터
        for (int i = 0; i < 100; i++) {
            datas.add("Data" + i);
        }
        // 2. 아답터
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, datas);

        // 3. 뷰 아답터 연결
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra(DATA_KEY,datas.get(position));
                startActivity(intent);
            }
        });
    }
```