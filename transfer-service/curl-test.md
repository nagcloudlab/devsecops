

```json
{
    "fromAccountId":1L,
    "toAccountId":2L,
    "amount":100.0,
}

```bash
curl -X POST http://localhost:8080/api/transfer \
     -H "Content-Type: application/json" \
     -d '{"fromAccountId":1,"toAccountId":2,"amount":10000.0}'
```
