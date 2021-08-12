using UnityEngine;
using System.Collections;

public class CameraShake : MonoBehaviour {

    public Camera mainCam;
    private float shakeAmount = 0;

    void Awake()
    {
        if(mainCam == null)
        {
            mainCam = Camera.main;
        }
    }

    void Update()
    {
        if(Input.GetKeyDown(KeyCode.T))
        {
            Shake(2, 0.2f);
        }
    }
	
    public void Shake(float amount, float length)
    {
        shakeAmount = amount;
        InvokeRepeating("beginShake", 0, 0.01f);
        Invoke("stopShake", length);
    }

    void beginShake()
    {
        if(shakeAmount > 0)
        {
            Vector3 camPos = mainCam.transform.position;

            float offsetX = Random.Range(0 - shakeAmount, shakeAmount);
            float offsetY = Random.Range(0 - shakeAmount, shakeAmount);
            camPos.x = offsetX;
            camPos.y = offsetY;
            camPos.z = 0;

            mainCam.transform.localPosition = camPos;
        }
    }

    void stopShake()
    {
        CancelInvoke("beginShake");

        mainCam.transform.localPosition = Vector3.zero;
    }
}
