✅ How to Send a Jira Webhook to Your Custom Tool
🔧 1. Set Up a Webhook in Jira
Go to Jira Settings → System

Under Advanced, choose Webhooks

Click Create a Webhook

Fill in the details:

Name: Send to Custom Tool

URL: http://your-custom-tool.domain.com/webhook-endpoint

Events: Choose which events (e.g., Issue Created, Updated, Transitioned)

JQL filter (optional): To limit which issues trigger it

📤 2. Jira Sends an HTTP POST Request
Whenever the configured event happens, Jira will send a POST request to your tool's URL with a JSON payload like:

json
Copy
Edit
{
  "timestamp": 1718043056451,
  "webhookEvent": "jira:issue_created",
  "issue": {
    "key": "PROJ-123",
    "fields": {
      "summary": "Bug in login flow",
      "status": {
        "name": "To Do"
      },
      ...
    }
  }
}
🛠️ 3. Your Custom Tool Receives and Handles It
Your tool must expose an endpoint that:

Listens for HTTP POST

Parses JSON

Acts on the event (e.g., logs it, triggers builds, updates a dashboard)

Sample in Express.js:

js
Copy
Edit
app.post('/webhook-endpoint', (req, res) => {
  const payload = req.body;
  console.log('Received from Jira:', payload);
  res.status(200).send('OK');
});
✅ Best Practices
✅ Use authentication (API token, secret header) on your endpoint

✅ Validate incoming requests (e.g., IP filtering, shared secret)

✅ Handle retries — Jira may retry if your endpoint fails

✅ Log or store payloads for audit/debug

