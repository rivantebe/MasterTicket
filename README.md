# Backend

```bash
docker build -t backend.
docker run -p 8080:8080 backend
```


## Autenticar Docker con GCP

```bash
gcloud components update
gcloud config set project "Tu Proyecto"
gcloud auth configure-docker
gcloud components update
```

### Subir la imagen a Google Container Registry (GCR)

```bash
docker tag your-app-name gcr.io/your-project-id/your-app-name
docker push gcr.io/your-project-id/your-app-name
```


### Desplegar en Cloud Run

```bash
gcloud run deploy your-app-name \
--image gcr.io/your-project-id/your-app-name \
--platform managed \
--region us-west2 \
--allow-unauthenticated
```
