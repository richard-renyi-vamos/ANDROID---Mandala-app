import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class MandalaGenerator {

    public static Bitmap generateMandala(int sides, int complexity, int width, int height) {
        Bitmap mandala = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(mandala);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        int centerX = width / 2;
        int centerY = height / 2;
        float radius = Math.min(centerX, centerY) * 0.9f;
        float angle = 360.0f / sides;
        int numCircles = complexity;

        for (int i = 0; i < numCircles; i++) {
            for (int j = 0; j < sides; j++) {
                float x1 = (float) (centerX + radius * Math.cos(Math.toRadians(j * angle)));
                float y1 = (float) (centerY + radius * Math.sin(Math.toRadians(j * angle)));
                float x2 = (float) (centerX + radius * Math.cos(Math.toRadians((j + 1) * angle)));
                float y2 = (float) (centerY + radius * Math.sin(Math.toRadians((j + 1) * angle)));
                canvas.drawLine(x1, y1, x2, y2, paint);
            }
            radius -= (radius / numCircles);
        }

        return mandala;
    }
}
