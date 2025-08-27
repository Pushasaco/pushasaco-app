import express from "express";
const app = express();
app.use(express.json());

app.get("/healthz", (_req, res) => res.json({ ok: true }));

app.get("/price-feed", async (_req, res) => {
  // TODO: fetch and cache prices; in dev return static
  res.json({ BTC: 60000, ETH: 3000 });
});

const port = process.env.PORT || 8080;
app.listen(port, () => console.log("Cloud Run svc on", port));