using UnityEngine;
using System.Collections;

public class Parallaxing : MonoBehaviour {

    public Transform[] background;  //Array of all back and fore-ground elements to be parallaxed
    private float[] parallaxScales; //Proportion of the camera's movement to move the backgrounds by
    public float smoothing = 1f;    //How smooth the parallax is going to be. Must be set above 0 to work

    private Transform cam;          //Reference to main camera transform
    private Vector3 previousCamPos; //Store the position of the camera in the previous frame

    //Is called before Start(). Great for assigning references
    void Awake()
    {
        //set up the cam reference
        cam = Camera.main.transform;

    }

	// Use this for initialization
	void Start () {
	    //Store previous frame; had the current frames cam pos
        previousCamPos = cam.position;

        //assigning corresponding parallaxScales
        parallaxScales = new float[background.Length];

        for(int k = 0; k < background.Length; k++)
        {
            parallaxScales[k] = background[k].position.z * -1;
        }
	}
	
	// Update is called once per frame
	void Update () {
	
        for(int i = 0; i < background.Length; i++)
        {
            //the parallax is the opposite of the camera movement because
            //the previous frame multiplied by the scale
            float parallax = (previousCamPos.x - cam.position.x) * parallaxScales[i];

            //set a target x position which is the current position plus the parallax
            float backgroundTargetPosX = background[i].position.x + parallax;

            //Create a target position which is the background current position with it's target x position
            Vector3 backgroundTargetPos = new Vector3(backgroundTargetPosX, background[i].position.y, background[i].position.z);

            //fade between cur pos and target pos using lerp
            background[i].position = Vector3.Lerp(background[i].position, backgroundTargetPos, smoothing * Time.deltaTime);
        }

        //set the previous cam position to current position
        previousCamPos = cam.position;
	}
}
