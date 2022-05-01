## Welcome to Vq


### Examples

```
%  echo '{"name":"Raj", "age":25}' | vq  "$.name"   
Raj
```

### Raw output

```
% echo '{"name":"Raj", "age":25, "address": {"city" : "seattle", zipcode: 94055} }' | vq  "$.address"  
{"city":"seattle","zipcode":94055}

```

### Pretty output
```
% echo '{"name":"Raj", "age":25, "address": {"city" : "seattle", zipcode: 94055} }' | vq  "pretty($.address)"  
{
  "city": "seattle",
  "zipcode": 94055
}
```

### Arrays

```
% echo '{"name":"Raj", "age":25, "gadgets": ["iPhone", "PS5"] }' | vq  "$.gadgets[1]"  
PS5

```

### Source

https://github.com/vqmind/vq


