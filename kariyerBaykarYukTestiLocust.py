from locust import HttpUser, task, between


class BaykarKariyerUser(HttpUser):
    host = "https://kariyer.baykartech.com"
    wait_time = between(1, 5)


    def on_start(self):
        self.client.get("/")

    @task
    def yuksek_irtifa(self):
        self.client.get("/yuksek-irtifa")

    @task
    def staj(self):
        self.client.get("/staj")

    @task
    def sss(self):
        self.client.get("/sss")

    @task
    def login(self):
        self.client.get("/hesaplar/login")