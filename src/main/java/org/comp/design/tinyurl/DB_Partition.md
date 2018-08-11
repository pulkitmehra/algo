

# Tables


## url table

userId  | originalUrl| tinyurl(pk) | ttl | isCustomName |  creationdate | updateDate |
--------|------------| ------- |-----|--------------|-------------------|-----|

## user table

userId(pk) | email| creationdate | updateDate |
--------|------------| ------- |-----|--------------|


## type of database : Cassandra

url `https://www.ebayinc.com/stories/blogs/tech/cassandra-data-modeling-best-practices-part-1/`

* Database: keyspace
* Table: ColumnFamily
* PrimaryKey: Rowkey

```
SortedMap<RowKey,  SortedMap<ColumnKey, ColumnValue>>> columnFamily
```
```
SortedMap<RowKey, SortedMap<SuperColumnKey, SortedMap<ColumnKey, ColumnValue>>> columnFalily
```

## type of Maps for tiny url : Cassandra

- tinyUrlColumnFamily

```
SortedMap<tinyurl,SortedMap<ColumnKey,ColumnValue>> tinyUrlColumnFamily
tinyUrlColumnFamily.put(originalUrl, value);
tinyUrlColumnFamily.put(userId, value);
tinyUrlColumnFamily.put(ttl, value);
tinyUrlColumnFamily.put(isCustomName, value);
```

- userIdColumnFamily

```
SortedMap<UserId,SortedMap<ColumnKey,ColumnValue>> userIdColumnFamily
userIdColumnFamily.put(email, value);

```


